package com.atkison.atkison2018.services;

import com.atkison.atkison2018.models.Ipaddress;
import com.atkison.atkison2018.models.Reserved;
import com.atkison.atkison2018.repository.IpRepository;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

@Service
public class IpAddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class.getName());

    @Autowired
    private IpRepository ipRepository;
    private DatabaseReader dbReader;//

    public IpAddressService() throws IOException {
        File database = new ClassPathResource("GeoLite2-City.mmdb").getFile();
        dbReader = new DatabaseReader.Builder(database).build();
        LOGGER.info("Creating the dbReader");
    }

    //I want to return an ip address to another service
    public void saveIpAddress(String ip, Reserved reserved) {

        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CityResponse response = dbReader.city(ipAddress);

            String cityName = response.getCity().getName();
            String latitude = response.getLocation().getLatitude().toString();
            String longitude = response.getLocation().getLongitude().toString();
            String postal = response.getPostal().getCode();
            Ipaddress ipaddress = new Ipaddress(ip, cityName, latitude, longitude, postal, reserved);
            this.ipRepository.save(ipaddress);
        } catch(Exception e) {
            LOGGER.error("Error saving new ipaddress " + e.getLocalizedMessage());
        }

    }

    public List<Ipaddress> getIpAddress() {
        return this.ipRepository.findAll();
    }





















}
