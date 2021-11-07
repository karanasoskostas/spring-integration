package pydra.integration.BalloonRead.ydrometra.YdrometraOnce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YdrometraOnceServiceImpl implements YdrometraOnceService{
    @Autowired
    private YdrometraOnceRepository eRepository;

    @Override
    public List<YdrometraOnce> getAllOnce() {
        return eRepository.getAllOnce();
    }
}
