package pydra.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pydra.integration.Snd_genpar.Sndgenpar;
import pydra.integration.Snd_genpar.SndgenparService;

import java.util.Properties;

@Configuration
public class GenparConfiguration {

    public static final Properties defaultProperties = new Properties();

    @Autowired
    private SndgenparService eService;

    @Bean
    public void GenparConfiguration() {
        Sndgenpar genpar = eService.getGenpar(1L);
        String smartvillename;
        defaultProperties.put("deyaAA", genpar.getDeyaaa().toString());
        defaultProperties.put("diadromhformat", genpar.getDiadromhformat());
        smartvillename = genpar.getSmartvillename();
        if (smartvillename == null) {
            smartvillename = "demo";
        }
        defaultProperties.put("smartvillename", smartvillename);
        //System.out.println(defaultProperties);
    }

}
