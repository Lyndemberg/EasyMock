
package Source;

import java.util.List;

public class EmpregadoManager {
    private IEmpregadoDAO dao;

    public EmpregadoManager(IEmpregadoDAO dao) {
        this.dao = dao;
    }
    
    public boolean validaEmpregado(Empregado e){
        if(e.getMatricula().length()>6 || e.getMatricula().isEmpty()) return false;
        if(e.getNome().length()>70 || e.getNome().isEmpty()) return false;
        if(e.getCpf().length()<11 || e.getCpf().isEmpty()) return false;
        if(e.getIdade()<0) return false;
        if(e.getSalario()<925) return false;
        if(e.getEndereco().getBairro().length()>100 || e.getEndereco().getBairro().isEmpty() ||
                e.getEndereco().getRua().length()>100 || e.getEndereco().getRua().isEmpty() ||
                e.getEndereco().getCidade().length()>100 || e.getEndereco().getCidade().isEmpty() ||
                e.getEndereco().getEstado().length()>2 || e.getEndereco().getEstado().isEmpty() ||
                e.getEndereco().getNumero()<0 || e.getEndereco().getCep()<0) return false;
        return true;
    }
    public boolean create(Empregado e){
        return dao.create(e);
    }
    public Empregado read(String matricula){
        return dao.read(matricula);
    }
    public boolean update(Empregado e){
        return dao.update(e);
    }
    public boolean delete(String matricula){
        return dao.delete(matricula);
    }
    public List<Empregado> list(){
        return dao.list();
    }
    
}
