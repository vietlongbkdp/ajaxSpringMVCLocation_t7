package com.cg.model.dto;

import com.cg.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LocationRegionCreReqDTO {
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;
    public LocationRegion toLocationRegion(){
        return new LocationRegion().setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);

    }
}
