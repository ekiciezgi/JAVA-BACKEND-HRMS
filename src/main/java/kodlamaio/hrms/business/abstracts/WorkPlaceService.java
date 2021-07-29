package kodlamaio.hrms.business.abstracts;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlace;

import java.util.List;
public interface WorkPlaceService {
    public DataResult<List<WorkPlace>> getAll();
}
