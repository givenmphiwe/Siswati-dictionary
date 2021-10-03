package octavia.dictionary.siswati;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AnimalLocationAdapter extends RecyclerView.Adapter<AnimalLocationAdapter.AnimalLocationViewHolder>{

    private List<AnimalLocation> animalLocations;

    public AnimalLocationAdapter(List<AnimalLocation> animalLocations) {
        this.animalLocations = animalLocations;
    }

    @NonNull
    @Override
    public AnimalLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimalLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalLocationViewHolder holder, int position) {
        holder.setLocationData(animalLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return animalLocations.size();
    }

    static class AnimalLocationViewHolder extends RecyclerView.ViewHolder{

        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStarRating;

        public AnimalLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            kbvLocation = itemView.findViewById(R.id.kbvlocation);
            textTitle = itemView.findViewById(R.id.textTittle);
            textLocation = itemView.findViewById(R.id.textlocation);
            //textStarRating = itemView.findViewById(R.id.textStarRating);
        }

        void setLocationData(AnimalLocation animalLocation){
            Picasso.get().load(animalLocation.imageurl).into(kbvLocation);
            textTitle.setText(animalLocation.title);
            textLocation.setText(animalLocation.location);
            //textStarRating.setText(String.valueof(animalLocation.starRating));
        }
    }
}
