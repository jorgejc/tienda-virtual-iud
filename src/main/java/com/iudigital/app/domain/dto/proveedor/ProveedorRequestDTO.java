package com.iudigital.app.domain.dto.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorRequestDTO implements Serializable { // TODO: implementar validaciones

    static final long serialVersionUID = 1L;

    @JsonProperty("nit")
    String nit;

    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("direccion")
    String direccion;

    @JsonProperty("telefono")
    String telefono;

    @JsonProperty("pagina_web")
    String paginaWeb;

}
