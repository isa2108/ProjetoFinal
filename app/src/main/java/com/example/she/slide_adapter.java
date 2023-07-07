package com.example.she;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class slide_adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slide_adapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.mipmap.use1,
            R.mipmap.use2,
            R.mipmap.use3

    };

    public String[] slide_heading = {
            "PASSO 1",
            "PASSO 2",
            "PASSO 3"
    };

    public String[] slide_dis = {
            "Para pedir ajuda, você precisa primeiro adicionar o número de contato de sua família ou amigos.",
            "No momento de emergência, pressione o botão de emergência para enviar uma mensagem de texto com sua localização para os contatos registrados.",
            "Se necessário, você pode ligar para os números de atendimento para obter ajuda."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textView1 = view.findViewById(R.id.txt_view5);
        TextView textView2 = view.findViewById(R.id.txt_view6);
        imageView.setImageResource(slide_images[position]);
        textView1.setText(slide_heading[position]);
        textView2.setText(slide_dis[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
