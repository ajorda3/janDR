package si.jandr.engine.dao;

import java.util.List;

import si.jandr.engine.models.Tool;

public interface ToolDAO {
	
	public void addTool(Tool tool);
	
	public void updateTool(Tool tool);

	public List<Tool> listTools();

	public Tool getToolById(int id);

	public void removeTool(int id);

}
