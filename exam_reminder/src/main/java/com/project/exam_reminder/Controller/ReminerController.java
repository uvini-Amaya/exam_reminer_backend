package com.project.exam_reminder.Controller;




        import com.example.cropdistributionms.dto.FarmerDTO;
        import com.example.cropdistributionms.dto.ResponseDTO;
        import com.example.cropdistributionms.dto.UserDTO;
        import com.example.cropdistributionms.service.FarmerService;
        import com.example.cropdistributionms.service.UserService;
        import com.example.cropdistributionms.util.VarList;
        import com.project.exam_reminder.Service.ReminderService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("api/v1/farmer")
@CrossOrigin("http://localhost:3000")

public class ReminerController {

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private examDTO examDTO;

    @PostMapping(value = "/saveReminder")
    public ExamEntity saveReminder(@RequestBody ReminderDTO reminderDTO){
        try {
            String res=reminderService.saveReminder( reminderDTO);
            if(res.equals("00")){
                examDTO.setCode(VarList.RSP_SUCCESS);
                examDTO.setMessage("Success");
                examDTO.setContent(reminderDTO);
                return new ExamEntity(examDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                examDTO.setCode(VarList.RSP_DUPLICATED);
                examDTO.setMessage("User Already Registered.");
                examDTO.setContent(reminderDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setM
        essage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping (value = "/updateFarmer")
    public ResponseEntity updateFarmer(@RequestBody FarmerDTO farmerDTO){
        try {
            String resp=farmerService.updateFarmer(farmerDTO);
            if(resp.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(resp.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not Registered User.");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllFarmers")
    public  ResponseEntity getAllFarmer(){
        try{
            List<FarmerDTO> farmerDTOList = farmerService.getAllFarmer();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Successful");
            responseDTO.setContent(farmerDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchFarmer/{farmerId}")
    public ResponseEntity searchFarmer(@PathVariable int farmerId){
        try {
            FarmerDTO farmerDTO = farmerService.searchFarmer(farmerId);
            if(farmerDTO !=null){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping ("/deleteFarmer/{farmerId}")
    public ResponseEntity deleteFarmer(@PathVariable int farmerId){
        try {
            String res = farmerService.deleteFarmer(farmerId);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}