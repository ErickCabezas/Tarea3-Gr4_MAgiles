package com.example.web;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProcesoPagoTest {

    @Test
    public void give_hacerPago_when_is_correct_then_OK(){
        InterfaceTarjeta interfacePago = Mockito.mock(InterfaceTarjeta.class);
        ProcesoPago procesar= new ProcesoPago(interfacePago);

        Mockito.when(interfacePago.solicitudDePago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.OK));
        assertTrue(procesar.hacerPagoTarjeta(300));

    }
    @Test
    public void give_hacerPago_when_is_correct_then_Error(){
        InterfaceTarjeta interfacePago = Mockito.mock(InterfaceTarjeta.class);
        ProcesoPago procesar= new ProcesoPago(interfacePago);

        Mockito.when(interfacePago.solicitudDePago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.ERROR));
        assertFalse(procesar.hacerPagoTarjeta(300));

    }

    @Test
    public void give_CancelarPago_when_is_correct_then_OK(){
        InterfaceTarjeta interfacePago = Mockito.mock(InterfaceTarjeta.class);
        ProcesoPago procesar= new ProcesoPago(interfacePago);

        Mockito.when(interfacePago.cancelarPago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.OK));
        assertTrue(procesar.cancelarPagoTarjeta(true));
    }
    @Test
    public void give_CancelarPago_when_is_correct_then_Error(){
        InterfaceTarjeta interfacePago = Mockito.mock(InterfaceTarjeta.class);
        ProcesoPago procesar= new ProcesoPago(interfacePago);

        Mockito.when(interfacePago.cancelarPago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.ERROR));
        assertFalse(procesar.cancelarPagoTarjeta(true));
    }

}

