package com.mats.consultoriodental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    ArrayList<Paciente> listaContactos;
    ArrayList<Paciente> listaOriginal;

    public ListaContactosAdapter(ArrayList<Paciente> listaContactos) {
        this.listaContactos = listaContactos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaContactos);
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_paciente, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

        holder.viewNombre.setText(listaContactos.get(position).getNombres());
        holder.viewApe.setText(listaContactos.get(position).getApellidos());
        holder.viewTelefono.setText(listaContactos.get(position).getTelefono());
        holder.viewNombre2.setText(listaContactos.get(position).getFecha());
        holder.viewHora.setText(listaContactos.get(position).getHoraInicio());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud ==0) {
            listaContactos.clear();
            listaContactos.addAll(listaOriginal);

        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Paciente> collecion = listaContactos.stream()
                        .filter(i -> i.getNombres().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaContactos.clear();
                listaContactos.addAll(collecion);
            } else {
                for (Paciente c : listaOriginal) {
                    if (c.getNombres().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaContactos.clear();
                        listaContactos.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewApe,viewTelefono, viewFecha,viewHora,viewFinal,viewNombre2;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = (TextView) itemView.findViewById(R.id.viewNombre);
            viewTelefono = (TextView) itemView.findViewById(R.id.viewTelefono);
            viewApe = (TextView) itemView.findViewById(R.id.viewApellido);
            viewNombre2=  (TextView) itemView.findViewById(R.id.viewNombre2);
            viewHora = (TextView) itemView.findViewById(R.id.viewNombre3);
            viewFinal=(TextView) itemView.findViewById(R.id.viewFinal);


                    itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, modificar_paciente.class);
                    intent.putExtra("ID", listaContactos.get(getAdapterPosition()).getEdad());
                    context.startActivity(intent);
                }
            });
        }
    }
}
