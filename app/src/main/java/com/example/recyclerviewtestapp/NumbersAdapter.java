package com.example.recyclerviewtestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;
    private int NumberItems;
    private Context parent;

    public NumbersAdapter (int numberOfItems, Context parent){
        NumberItems = numberOfItems;
        viewHolderCount = 0;
        this.parent = parent;
    }
    @NonNull
    @NotNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //Создаем новые ВьюХолдеры
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item; //находим ИД нашего хмл

        LayoutInflater inflater = LayoutInflater.from(context);//инфлейтор для создания ВХ


        View viewJO = inflater.inflate(layoutIdForListItem, parent, false);//создаем объект класса вью из хмл
        // первый параметр это айди нашего хмл, второй это родитель этого элемента. Мы ставим туда парент,
        //чтоб все помещалось в наш ресайклвью
        //3 параметр спрашивает надо ли элемент помещать в родителя.

        NumberViewHolder viewHolder = new NumberViewHolder(viewJO);//создаем ВХ и оборачиваем в него наш объект с хмл
        viewHolder.viewHolderIndex.setText("VH index " +viewHolderCount);
        viewHolderCount++;

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NumberViewHolder holder, int position) {
        //У созданых ВХ меняем значения
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        //Должен вернуть общее количество элементов списка
        return NumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;
        TextView viewHolderIndex;

        public NumberViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //показываем toast
                    int posInd = getAbsoluteAdapterPosition();
                    Toast toast = Toast.makeText(parent, "Нажат холдер № "+posInd,Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }

        void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
