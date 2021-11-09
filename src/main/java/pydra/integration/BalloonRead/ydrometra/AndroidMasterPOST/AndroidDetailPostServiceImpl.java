package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AndroidDetailPostServiceImpl implements  AndroidDetailPostService{

    @Autowired
    private AndroidDetailPostRepository eRepository;

    @Override
    public List<AndroidDetailPost> getallByFileId(Long file_id) {
        return eRepository.findByFile_id(file_id);
    }
}
