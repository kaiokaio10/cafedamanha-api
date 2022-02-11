package cafedamanha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/colaborador")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("http://localhost:4200")
public class ColaboradorController {
	
	@GetMapping("/teste")
	public String test() {
		return "teste api cafe da manha";
	}

}
