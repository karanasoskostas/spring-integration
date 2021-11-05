package pydra.integration.Snd_genpar;

import org.springframework.beans.factory.annotation.Autowired;

public class GetgenparOnStart {

    @Autowired
    private SndgenparService genparService;

    public String diadromhformat="";

    public String getDiadromhformat() {
        Sndgenpar genpar = genparService.getGenpar(1L);
        return genpar.getDiadromhformat();
    }
}
