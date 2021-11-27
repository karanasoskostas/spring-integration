package pydra.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pydra.integration.Com_parms.Comparms;
import pydra.integration.Com_parms.ComparmsService;
import pydra.integration.Snd_genpar.Sndgenpar;
import pydra.integration.Snd_genpar.SndgenparService;

import java.util.Properties;

@Configuration
public class GenparConfiguration {

    public static final Properties defaultProperties = new Properties();

    @Autowired
    private SndgenparService genService;
    @Autowired
    private ComparmsService comService;

    @Bean
    public void GenparConfiguration() {
        Sndgenpar genpar = genService.getGenpar(1L);
        Comparms comparm = comService.getComparms(1L);
        String smartvillename = "";
        String afmusername = "";
        String afmpassword = "";

        defaultProperties.put("deyaAA", genpar.getDeyaaa().toString());
        defaultProperties.put("diadromhformat", genpar.getDiadromhformat());
        smartvillename = genpar.getSmartvillename();
        if (smartvillename == null) {
            smartvillename = "demo";
        }
        defaultProperties.put("smartvillename", smartvillename);
        afmusername = comparm.getGsisafmcode();
        if (afmusername == null){
            afmusername = "";
        }
        afmpassword = comparm.getGsispecialcode();
        if (afmpassword == null) {
            afmpassword = "";
        }
        defaultProperties.put("afmusername", afmusername);
        defaultProperties.put("afmpassword", afmpassword );
        //System.out.println(defaultProperties);
    }

}
