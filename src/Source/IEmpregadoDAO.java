package Source;

import java.util.List;

public interface IEmpregadoDAO {
    boolean create(Empregado e);
    Empregado read(String matricula);
    boolean update(Empregado e);
    boolean delete(String matricula);
    List<Empregado> list();
}
