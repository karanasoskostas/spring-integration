package pydra.integration.BalloonRead.ydrometra.YdrometraDates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;

@Service
public class YdrometraDatesServiceImpl implements YdrometraDatesService{

    @Autowired
    private YdrometraDatesRepository eRepository;

    @Override
    public List<YdrometraDates> getAllagesDates(String fromdate, String todate) {
        List<YdrometraDates>  ydrometra = null;
        try{
            ydrometra = eRepository.getAllagesDates(fromdate, todate);
        } catch(Exception ex){
            throw new GeneralException("YdrometraDatesServiceImpl getAllagesDates Exception :"+ex.getMessage());
        }
        if (ydrometra.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν Εγγραφές");
        }
        return ydrometra;
    }
}
