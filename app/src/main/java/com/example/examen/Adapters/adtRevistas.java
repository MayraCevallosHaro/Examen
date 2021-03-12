package com.example.examen.Adapters;

public class adtRevistas extends RecyclerView.Adapter<adtRevistas.ViewHolder> implements View.OnClickListener{
    private List<Revistas> datos;
    // Constructor de la clase
    public adtRevistas(List<Revistas> info) {this.datos = info;}

    private View.OnClickListener listener;

    @NonNull
    @Override
    public adtRevistas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_shimmeraglome,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adtRevistas.ViewHolder holder, int position) {
        if(showShimmer)
        {
            holder.shimmerFrameLayout.startShimmer();
        }
        else
        {
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
            holder.txtFechaHoraAglome.setBackground(null);
            holder.txtTipoAglomeracion.setBackground(null);
            holder.imgAglomeracion.setBackground(null);
            holder.asignar_datos(datos.get(position));
        }
    }

    @Override
    public int getItemCount() {
        try{ return showShimmer ? cantShimmer : datos.size(); } catch (Exception e) {return cantShimmer;}
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShimmerFrameLayout shimmerFrameLayout;
        TextView txtFechaHoraAglome, txtTipoAglomeracion;
        ImageView imgAglomeracion;
        //Button btnRestaurant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmer);
            txtFechaHoraAglome = (TextView) itemView.findViewById(R.id.txtFechaHoraAglomeN);
            txtTipoAglomeracion = (TextView) itemView.findViewById(R.id.txtTipoAglomeracionN);
            imgAglomeracion = (ImageView) itemView.findViewById(R.id.imgAglomeracionN);
        }

        @SuppressLint("ResourceAsColor")
        public void asignar_datos(Revistas valor) {
            txtFechaHoraAglome.setText(valor.getFecha() + " " + valor.getHora());
            txtFechaHoraAglome.setTextColor(Negro);
            txtTipoAglomeracion.setText(valor.getTitulo());
            txtTipoAglomeracion.setTextColor(Negro);
            Glide.with(itemView).load(valor.getImagen()).centerCrop().into(imgAglomeracion);
        }
}
