package com.example.proyectin.controlador.swvolly;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectin.modelo.Cliente;
import com.example.proyectin.vista.ActivityNavegation;

import org.json.JSONException;
import org.json.JSONObject;

public class ServicioWeb {
    Context context;
    String ip, puerto, url;
    boolean estado;

    public ServicioWeb(String ip, String puerto, Context context) {
        this.ip = ip;
        this.puerto = puerto;
        this.context = context;

    }

    public Context getContext() {
        return getContext();
    }

    public void login(String user, String passw) {
        String urlLogin = "http://192.168.1.14:8080/ingresar";
        JSONObject json = new JSONObject();

        try {
            json.put("nombre", user);
            json.put("cedula", passw);
        } catch (JSONException e) {
            Log.e("JSON ERROR", e.getMessage());
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, urlLogin, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        context.startActivity(new Intent(context, ActivityNavegation.class));
                        Log.e("Ha iniciado Sesion!!", response.toString());
                        // estado = true;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Usuario o Contraseña Invalidos", Toast.LENGTH_SHORT).show();
            }
        });
        volleySingleton.getInstance(context).addToRequestque(jsonObjectRequest);

    }

    public boolean insertar(Cliente cliente) {
        String url =  "http://localhost:8080/agregarcliente";
        JSONObject json = new JSONObject();
        try {
            json.put("cedula", cliente.getCedula());
            json.put("nombre", cliente.getNombre());
            json.put("Apellido", cliente.getApellido());
            json.put("telefono", cliente.getTelefono());
            json.put("direccion", cliente.getDireccion());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                estado = true;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                estado = false;

            }
        }

        );
        volleySingleton.getInstance(context).addToRequestque(jsonObjectRequest);
        return estado;
    }
}
