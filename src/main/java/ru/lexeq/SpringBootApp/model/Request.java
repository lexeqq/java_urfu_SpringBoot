package ru.lexeq.SpringBootApp.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lexeq.SpringBootApp.util.DateTimeUtil;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    // Не пустой, макс. размер до 32 символов
    @NotBlank
    @Size(max = 32)
    private String uid;

    // До 32 символов
    @Size(max = 32)
    private String operationUid;

    private Systems systemName;
    private String systemTime;
    private String source;

    // Поле для передачи времени получения запроса
    private String service1RequestTime;


    // Диапазон валидных значений
    @Min(value = 1)
    @Max(value = 100000)
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid= " + uid + '\'' +
                ", operationUid= " + operationUid + '\'' +
                ", systemName= " + systemName + '\'' +
                ", systemTime= " + systemTime + '\'' +
                ", source= " + source + '\'' +
                ", service1RequestTime= " + service1RequestTime + '\'' +
                ", communicationId= " + communicationId +
                ", templateId= " + templateId +
                ", productCode= " + productCode +
                ", smsCode= " + smsCode +
                '}';
    }
}
