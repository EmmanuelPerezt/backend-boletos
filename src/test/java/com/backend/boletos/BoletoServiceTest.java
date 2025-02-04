package com.backend.boletos;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.backend.boletos.model.BoletoModel;
import com.backend.boletos.model.EventoModel;
import com.backend.boletos.model.UsuarioModel;
import com.backend.boletos.repository.BoletoRepository;
import com.backend.boletos.service.BoletoService;

@ExtendWith(MockitoExtension.class)
public class BoletoServiceTest {
    
    @Mock
    private BoletoRepository boletoRepository;
    @InjectMocks
    private BoletoService boletoService;
    
    @Test
    void findBoleto() {
        UUID uuid = UUID.randomUUID();
        BoletoModel boleto = new BoletoModel(uuid,100,new EventoModel(),new UsuarioModel() );
        when(boletoRepository.findById(uuid)).thenReturn(Optional.of(boleto));

        BoletoModel result = boletoService.getBoleto(uuid);
        assertNotNull(result);
        assertEquals(boleto.getId_boleto(),result.getId_boleto());
    }
}
