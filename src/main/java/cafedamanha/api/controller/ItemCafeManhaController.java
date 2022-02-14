package cafedamanha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cafedamanha.api.service.ItemCafeManhaService;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/itemcafemanha")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("https://cafemanhafront-api.herokuapp.com/")
public class ItemCafeManhaController {

	private final ItemCafeManhaService service;

	@GetMapping()
	public ResponseEntity<?> listarItemCafeManha() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarItemCafeManha());
	}
	
	
	
}
