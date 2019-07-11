package com.imie.g7.edycem_android.database.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imie.g7.edycem_android.R;
import com.imie.g7.edycem_android.activity.HomeActivity;
import com.imie.g7.edycem_android.database.dto.ProjectDto;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private HomeActivity activity = null;
    private List<ProjectDto> listProjectDto = null;

    public ProjectAdapter(HomeActivity activity, List<ProjectDto> listProjectDto) {
        this.activity = activity;
        this.listProjectDto = listProjectDto;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View viewProject = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project,
                parent, false);
        return new ProjectViewHolder(viewProject);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        //holder.textViewIntitule.setText(listeMemoDTO.get(position).intitule);
    }

    @Override
    public int getItemCount() {
        return listProjectDto.size();
    }

    public ProjectDto getProjectDtoByPosition(int position) {
        return listProjectDto.get(position);
    }

    /**
     * ViewHolder.
     */
    class ProjectViewHolder extends RecyclerView.ViewHolder {

        TextView textViewProjectTitle = null;

        ProjectViewHolder(final View itemView)  {
            super(itemView);
            textViewProjectTitle = itemView.findViewById(R.id.projectTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onClicItem(getAdapterPosition());
                }
            });
        }

    }

}
