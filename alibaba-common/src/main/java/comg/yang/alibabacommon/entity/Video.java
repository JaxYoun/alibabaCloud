package comg.yang.alibabacommon.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private Long id;

    private String tittle;

    private LocalDate date;

    private String address;

}
