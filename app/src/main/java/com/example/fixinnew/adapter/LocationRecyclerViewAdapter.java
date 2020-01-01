package com.example.fixinnew.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.Dashboard;
import com.example.fixinnew.R;
import com.example.fixinnew.model.IndividualLocation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * RecyclerView adapter to display a list of location cards on top of the map
 */
public class LocationRecyclerViewAdapter extends
  RecyclerView.Adapter<LocationRecyclerViewAdapter.ViewHolder> {

  Dashboard dashboard;
  private List<IndividualLocation> listOfLocations;
  private Context context;
  private int selectedTheme;
  private static ClickListener clickListener;
  private Drawable emojiForCircle = null;
  private Drawable backgroundCircle = null;
  private int upperCardSectionColor = 0;

  private int locationNameColor = 0;
  private int locationAddressColor = 0;
  private int locationPhoneNumColor = 0;
  private int locationPhoneHeaderColor = 0;
  private int locationHoursColor = 0;
  private int locationHoursHeaderColor = 0;
  private int locationDistanceNumColor = 0;
  private int milesAbbreviationColor = 0;

  public LocationRecyclerViewAdapter(List<IndividualLocation> styles,
                                     Context context, ClickListener cardClickListener, int selectedTheme) {
    this.context = context;
    this.listOfLocations = styles;
    this.selectedTheme = selectedTheme;
    this.clickListener = cardClickListener;
    dashboard = new Dashboard();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    int singleRvCardToUse = R.layout.single_location_map_view_rv_card;
    View itemView = LayoutInflater.from(parent.getContext()).inflate(singleRvCardToUse, parent, false);
    return new ViewHolder(itemView);
  }

  public interface ClickListener {
    void onItemClick(int position);
  }

  @Override
  public int getItemCount() {
    return listOfLocations.size();
  }

  @Override
  public void onBindViewHolder(ViewHolder card, int position) {

    IndividualLocation locationCard = listOfLocations.get(position);

    card.bNama.setText(locationCard.getName());
    Picasso.get().load("http://10.212.160.187/fix/foto/" + locationCard.getAddress()).into(card.bGambar);
//    System.out.println(locationCard.getDistance());
    System.out.println(locationCard.getAddress());
//    card.addressTextView.setText(locationCard.getAddress());
//    card.phoneNumTextView.setText(locationCard.getPhoneNum());
//    card.hoursTextView.setText(locationCard.getHours());
//    card.distanceNumberTextView.setText(locationCard.getDistance());

    switch (selectedTheme) {
      case R.style.AppTheme_Blue:
        emojiForCircle = ResourcesCompat.getDrawable(context.getResources(), R.drawable.logo, null);
        backgroundCircle = ResourcesCompat.getDrawable(context.getResources(), R.drawable.blue_circle, null);
        setColors(R.color.colorPrimary_blue, R.color.white, R.color.white, R.color.cardHourAndPhoneTextColor_blue,
          R.color.cardHourAndPhoneHeaderTextColor_blue, R.color.cardHourAndPhoneTextColor_blue,
          R.color.cardHourAndPhoneHeaderTextColor_blue, R.color.white, R.color.white);
        setAlphas(card, .41f, .48f, 100f, .48f,
          100f,
          .41f);
        break;
      case R.style.AppTheme_Purple:
        emojiForCircle = ResourcesCompat.getDrawable(context.getResources(), R.drawable.logo, null);
        backgroundCircle = ResourcesCompat.getDrawable(context.getResources(), R.drawable.purple_circle, null);
        setColors(R.color.colorPrimaryDark_purple, R.color.white, R.color.white, R.color.cardHourAndPhoneTextColor_purple,
          R.color.cardHourAndPhoneTextColor_purple, R.color.cardHourAndPhoneTextColor_purple,
          R.color.cardHourAndPhoneTextColor_purple, R.color.white, R.color.white);
        setAlphas(card, .41f, .36f, .94f, .36f,
          .94f,
          .41f);
        break;

    }

//    card.emojiImageView.setImageDrawable(emojiForCircle);
//    card.constraintUpperColorSection.setBackgroundColor(upperCardSectionColor);
//    card.backgroundCircleImageView.setImageDrawable(backgroundCircle);
//    card.nameTextView.setTextColor(locationNameColor);
//    card.phoneNumTextView.setTextColor(locationPhoneNumColor);
//    card.hoursTextView.setTextColor(locationHoursColor);
//    card.hoursHeaderTextView.setTextColor(locationHoursHeaderColor);
//    card.distanceNumberTextView.setTextColor(locationDistanceNumColor);
//    card.milesAbbreviationTextView.setTextColor(milesAbbreviationColor);
//    card.addressTextView.setTextColor(locationAddressColor);
//    card.phoneHeaderTextView.setTextColor(locationPhoneHeaderColor);
  }

  private void setColors(int colorForUpperCard, int colorForName, int colorForAddress,
                         int colorForHours, int colorForHoursHeader, int colorForPhoneNum,
                         int colorForPhoneHeader, int colorForDistanceNum, int colorForMilesAbbreviation) {
    upperCardSectionColor = ResourcesCompat.getColor(context.getResources(), colorForUpperCard, null);
    locationNameColor = ResourcesCompat.getColor(context.getResources(), colorForName, null);
    locationAddressColor = ResourcesCompat.getColor(context.getResources(), colorForAddress, null);
    locationHoursColor = ResourcesCompat.getColor(context.getResources(), colorForHours, null);
    locationHoursHeaderColor = ResourcesCompat.getColor(context.getResources(), colorForHoursHeader, null);
    locationPhoneNumColor = ResourcesCompat.getColor(context.getResources(), colorForPhoneNum, null);
    locationPhoneHeaderColor = ResourcesCompat.getColor(context.getResources(), colorForPhoneHeader, null);
    locationDistanceNumColor = ResourcesCompat.getColor(context.getResources(), colorForDistanceNum, null);
    milesAbbreviationColor = ResourcesCompat.getColor(context.getResources(), colorForMilesAbbreviation, null);
  }

  private void setAlphas(ViewHolder card, float addressAlpha, float hoursHeaderAlpha, float hoursNumAlpha,
                         float phoneHeaderAlpha, float phoneNumAlpha, float milesAbbreviationAlpha) {
//    card.bNama.setAlpha(addressAlpha);
//    card.bGambar.setAlpha(hoursHeaderAlpha);
//    card.hoursTextView.setAlpha(hoursNumAlpha);
//    card.phoneHeaderTextView.setAlpha(phoneHeaderAlpha);
//    card.phoneNumTextView.setAlpha(phoneNumAlpha);
//    card.milesAbbreviationTextView.setAlpha(milesAbbreviationAlpha);
  }


  static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView bGambar;
    TextView bNama;
    Button btnDetail;
    Button btnNavigasi;

//    TextView nameTextView;
//    TextView addressTextView;
//    TextView phoneNumTextView;
//    TextView hoursTextView;
//    TextView distanceNumberTextView;
//    TextView hoursHeaderTextView;
//    TextView milesAbbreviationTextView;
//    TextView phoneHeaderTextView;
//    ConstraintLayout constraintUpperColorSection;
    CardView cardView;
//    ImageView backgroundCircleImageView;
//    ImageView emojiImageView;

    ViewHolder(View itemView) {
      super(itemView);
      bNama = itemView.findViewById(R.id.namaBengkel);
      bGambar = itemView.findViewById(R.id.ivBengkel);
      cardView = itemView.findViewById(R.id.map_view_location_card);
      btnDetail = (Button) itemView.findViewById(R.id.buttonDetail);


      cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          clickListener.onItemClick(getLayoutPosition());
        }
      });
    }

    @Override
    public void onClick(View view) {

    }
  }
}
