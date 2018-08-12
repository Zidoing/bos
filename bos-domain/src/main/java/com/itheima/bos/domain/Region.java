package com.itheima.bos.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Entity
@Table(name = "bc_region", schema = "bos32", catalog = "")
public class Region {
    private String id;
    private String province;
    private String city;
    private String district;
    private String postcode;
    private String shortcode;
    private String citycode;
    private Collection<Subarea> bcSubareasById;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 50)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 50)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "postcode", nullable = true, length = 50)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "shortcode", nullable = true, length = 30)
    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    @Basic
    @Column(name = "citycode", nullable = true, length = 30)
    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != null ? !id.equals(region.id) : region.id != null) return false;
        if (province != null ? !province.equals(region.province) : region.province != null) return false;
        if (city != null ? !city.equals(region.city) : region.city != null) return false;
        if (district != null ? !district.equals(region.district) : region.district != null) return false;
        if (postcode != null ? !postcode.equals(region.postcode) : region.postcode != null) return false;
        if (shortcode != null ? !shortcode.equals(region.shortcode) : region.shortcode != null) return false;
        if (citycode != null ? !citycode.equals(region.citycode) : region.citycode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (shortcode != null ? shortcode.hashCode() : 0);
        result = 31 * result + (citycode != null ? citycode.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bcRegionByRegionId")
    public Collection <Subarea> getBcSubareasById() {
        return bcSubareasById;
    }

    public void setBcSubareasById(Collection <Subarea> bcSubareasById) {
        this.bcSubareasById = bcSubareasById;
    }
}