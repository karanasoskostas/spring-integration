package pydra.integration.BalloonRead.ydrometra.YdrometraDates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YdrometraDatesServiceImpl implements YdrometraDatesService{

    @Autowired
    private YdrometraDatesRepository eRepository;

    @Override
    public List<YdrometraDates> getAllagesDates(String fromdate, String todate) {
        return eRepository.getAllagesDates(fromdate, todate);
    }
}
