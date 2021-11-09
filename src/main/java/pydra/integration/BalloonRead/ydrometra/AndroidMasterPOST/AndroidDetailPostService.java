package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import java.util.List;

public interface AndroidDetailPostService {
    List<AndroidDetailPost> getallByFileId(Long file_id);
}
