package com.example.fixinnew;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class Maps extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener, MapboxMap.OnMapClickListener {

    Button startButton;
    MapView mapView;
    private MapboxMap mapboxMap;
    private PermissionsManager permissionsManager;
//    private LocationEngine locationEngine;
//    private LocationLayerPlugin locationLayerPlugin;
    private Location originLocation;
    private Point originPosition;
    private Point destinationPosition;
    private Marker destinationMarker;
    private NavigationMapRoute navigationMapRoute;
    private static final String TAG = "Maps";

    private final Random random = new Random();
    private SymbolManager symbolManager;
    private Symbol symbol;
    private static final String ID_ICON_AIRPORT = "airport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiZGFuaW5kcmEiLCJhIjoiY2szNzZ4Y3Z3MDlncjNrczFsc290bnI4aiJ9.hd2BKXV3iZWNQCOldxeZdA");
        setContentView(R.layout.activity_maps);
        startButton = findViewById(R.id.buttonNavigasi);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);




        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addAirplaneImageToStyle(Style style) {
        style.addImage(ID_ICON_AIRPORT,
                BitmapUtils.getBitmapFromDrawable(getResources().getDrawable(R.drawable.logo)),
                true);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(this, R.string.permissions, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {

                    enableLocationComponent(style);
                }
            });
        } else {
            Toast.makeText(this, R.string.permissions, Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        Maps.this.mapboxMap = mapboxMap;
        mapboxMap.addOnMapClickListener(this);



        mapboxMap.addMarker(new MarkerOptions()
        .position(new LatLng(-7.356860504226162, 112.73730423559346))
                .title("bengkel1")
        );



//        mapboxMap.addMarker(new MarkerOptions()
//                .position(new LatLng(-7.357286621453525, 112.73401447080107))
//                .title("bengkel2")
//        );

        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/mapbox/cjerxnqt3cgvp2rmyuxbeqme7"),
                new Style.OnStyleLoaded() {

                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
                        style.addImage("my-marker",bm);

                        addAirplaneImageToStyle(style);

                        // create symbol manager
                        GeoJsonOptions geoJsonOptions = new GeoJsonOptions().withTolerance(0.4f);
                        symbolManager = new SymbolManager(mapView, mapboxMap,style,null, geoJsonOptions);
                        symbolManager.addClickListener(symbol -> Toast.makeText(Maps.this,
                                String.format("Symbol clicked %s", symbol.getId()),
                                Toast.LENGTH_SHORT
                        ).show());
                        symbolManager.addLongClickListener(symbol ->
                                Toast.makeText(Maps.this,
                                        String.format("Symbol long clicked %s", symbol.getId()),
                                        Toast.LENGTH_SHORT
                                ).show());

                        // set non data driven properties
                        symbolManager.setIconAllowOverlap(true);
                        symbolManager.setTextAllowOverlap(true);

                        // create a symbol
                        SymbolOptions symbolOptions = new SymbolOptions()
                                .withLatLng(new LatLng(-7.357286621453525, 112.73401447080107))
                                .withIconImage("my-marker")
                                .withIconSize(0.3f)
                                .withSymbolSortKey(10.0f)
                                .withDraggable(true);
                        symbol = symbolManager.create(symbolOptions);
                        Timber.e(symbol.toString());

                        enableLocationComponent(style);
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressWarnings( {"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
// Check if permissions are enabled and if not request
        if (PermissionsManager.areLocationPermissionsGranted(this)) {

// Get an instance of the component
            LocationComponent locationComponent = mapboxMap.getLocationComponent();

// Activate with options
            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(this, loadedMapStyle).build());

// Enable to make component visible
            locationComponent.setLocationComponentEnabled(true);
            originLocation = locationComponent.getLastKnownLocation();

// Set the component's camera mode
            locationComponent.setCameraMode(CameraMode.TRACKING);

// Set the component's render mode
            locationComponent.setRenderMode(RenderMode.COMPASS);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {

        if (destinationMarker != null){
            mapboxMap.removeMarker(destinationMarker);
        }

        destinationMarker = mapboxMap.addMarker(new MarkerOptions().position(point));
        destinationPosition = Point.fromLngLat(point.getLongitude(), point.getLatitude());
        originPosition = Point.fromLngLat(originLocation.getLongitude(), originLocation.getLatitude());
        System.out.println(destinationPosition);

        getRoute(originPosition, destinationPosition);
        startButton.setEnabled(true);
        return false;
    }

    private void getRoute(Point origin, Point destination) {
        NavigationRoute.builder(this)
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if(response.body() == null) {
                            Log.e(TAG, "No routes found, check right user and access token");
                            return;
                        } else if(response.body().routes().size() == 0) {
                            Log.e(TAG, "No routes found");
                            return;
                        }

                        DirectionsRoute currentRoute = response.body().routes().get(0);

                        if(navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, mapboxMap);
                        }

                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                    }
                });
    }




}
