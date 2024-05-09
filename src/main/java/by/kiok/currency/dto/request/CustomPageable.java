package by.kiok.currency.dto.request;

import javax.validation.constraints.Min;

public record CustomPageable(

        @Min(1)
        int pageNumber,

        @Min(1)
        int pageSize
) {
    public int getOffset() {
        return (pageNumber - 1) * pageSize;
    }
}
