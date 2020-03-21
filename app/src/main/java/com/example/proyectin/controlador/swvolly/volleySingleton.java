package com.example.proyectin.controlador.swvolly;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class volleySingleton {

    private RequestQueue queue;
    private Context context;
    private static volleySingleton miInstacia;

    public volleySingleton(Context contexto) {
        context = contexto;
        queue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){
        if(queue == null){
            queue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return queue;
    }

    public static synchronized volleySingleton getInstance(Context contexto){
        if(miInstacia == null){
            miInstacia = new volleySingleton(contexto);
        }
        return miInstacia;
    }


    public <T> void addToRequestque(Request request){
        queue.add(request);
    }

}
