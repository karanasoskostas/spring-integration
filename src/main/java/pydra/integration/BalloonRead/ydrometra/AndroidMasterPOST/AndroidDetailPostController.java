package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AndroidDetailPostController {

    @Autowired
    private AndroidDetailPostService eService;

    @GetMapping("/AndroidDetailPost/{file_id}")
    public ResponseEntity<List<AndroidDetailPost>> getByFile_id(@PathVariable("file_id") Long file_id){
        return new ResponseEntity<List<AndroidDetailPost>>(eService.getallByFileId(file_id), HttpStatus.OK);
    }
}
