package hu.mev.lev.Beadando.SpringBoot.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class BookDTO {
    @Min(0)
    private Long ISDN;
    @NotBlank
    private String name;
    @Min(1)
    private Integer howMany;
    @Min(0)
    private Long author_id;
}
