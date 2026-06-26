package com.alicorp.demo_alicorp.service;
import com.alicorp.demo_alicorp.dto.request.RegistrarOperacionRequest;
import com.alicorp.demo_alicorp.dto.response.Response;
import com.alicorp.demo_alicorp.entity.Estado;
import com.alicorp.demo_alicorp.entity.Moneda;
import com.alicorp.demo_alicorp.entity.Operacion;
import com.alicorp.demo_alicorp.repository.OperacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OperacionService {
    private OperacionRepository operacionRepository;

    public OperacionService(OperacionRepository operacionRepository) {
        this.operacionRepository = operacionRepository;
    }

    public Response<List<Operacion>> ListarOperaciones(Estado estado) {
        Response<List<Operacion>> response = new Response<List<Operacion>>();
        List<Operacion> operaciones = operacionRepository.findByEstado(estado);
        response.setSuccess(true);
        response.setData(operaciones);
        response.setMessage("Operaciones encontradas");
        return response;
    }


    public Response<Operacion> RegistrarOperacion(RegistrarOperacionRequest req) {
        Operacion operacion = new Operacion();
        Response<Operacion> response = new Response<Operacion>();

        if(req.getMoneda_origen().equals(req.getMoneda_destino())){
            response.setMessage("Los monedas no pueden ser iguales");
            return response;
        }

        if(req.getTipo_cambio()>0 && req.getMonto_origen()>0){
            response.setMessage("El tipo de cambio y el monto de origen deben ser mayores a cero");
            return response;
        }

        operacion.setMoneda_origen(req.getMoneda_origen());
        operacion.setMoneda_destino(req.getMoneda_destino());
        operacion.setTipo_cambio(req.getTipo_cambio());
        operacion.setMonto_origen(req.getMonto_origen());
        operacion.setEstado(req.getEstado());
        operacion.setFecha_operacion(req.getFecha_operacion());
        Operacion guardado = operacionRepository.save(operacion);

        response.setSuccess(Boolean.TRUE);
        response.setMessage("Operación registrada correctamente");
        response.setData(guardado);

        return response;
    }

    public Response<Boolean> ActualizarEstado(Long id, Estado estado) {
        Response<Boolean> response = new Response<>();
        response.setSuccess(Boolean.FALSE);
        Optional<Operacion> opp = operacionRepository.findById(id);

        if(opp.isPresent()) {
            Operacion op = opp.get();

            if (!Objects.equals(op.getEstado(), Estado.ANULADA)) {
                op.setEstado(estado);
                operacionRepository.save(op);
                response.setSuccess(Boolean.TRUE);
                response.setMessage("Actualizado exitosamente");
            }
            else {
                response.setMessage("No se puede actualizar el estado de operaciones anuladas");
            }
        }else{
            response.setMessage("Operacion no encontrada");
        }
        return response;
    }

}
