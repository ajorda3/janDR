package si.jandr.engine.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import si.jandr.engine.dao.ToolDAO;
import si.jandr.engine.models.Tool;

@Controller
public class ToolController {

	private ToolDAO toolDAO;

	@Autowired(required = true)
	@Qualifier(value = "toolDAO")
	public void settoolDAO(ToolDAO toolDao) {
		this.toolDAO = toolDao;
	}

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//model.addAttribute("person", new Person());
		
		Tool tool = this.toolDAO.getToolById(0);
		
		return tool.getName();
		
		
//		List<Tool> tools = this.toolDAO.listTools();
//		
//		String returnListTools = "";
//		for (Tool tool : tools ) {
//			returnListTools += tool + " \n";
//		}
//				
//		return returnListTools;
	}

}
