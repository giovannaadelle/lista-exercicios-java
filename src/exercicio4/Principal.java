package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main (String[] args) {
        List<IMeioTransporte> meiosDeTransporte = new ArrayList<>();

        meiosDeTransporte.add(new Carro());
        meiosDeTransporte.add(new Bicicleta());
        meiosDeTransporte.add(new Trem());

        for (IMeioTransporte meioTransporte : meiosDeTransporte) {
            try {
                meioTransporte.acelerar();
                meioTransporte.acelerar();
                meioTransporte.frear();
                meioTransporte.frear();
                meioTransporte.frear();
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}