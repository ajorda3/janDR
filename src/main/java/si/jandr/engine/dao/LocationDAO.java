package si.jandr.engine.dao;

import java.util.List;

import si.jandr.engine.models.Location;

public interface LocationDAO {
	
	public void addLocation(Location Location);
	
	public void updateLocation(Location Location);

	public List<Location> listLocations();

	public Location getLocationById(int id);

	public void removeLocation(int id);

}
