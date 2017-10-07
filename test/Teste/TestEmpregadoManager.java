package Teste;

import Source.Empregado;
import Source.EmpregadoManager;
import Source.Endereco;
import Source.IEmpregadoDAO;
import org.easymock.EasyMock;
import org.easymock.MockType;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestEmpregadoManager {
    private IEmpregadoDAO dao = null;
    
    @Before
    public void inicializa(){
        dao = EasyMock.createMock(IEmpregadoDAO.class);
    }
    
    @Test
    public void test_1(){
        Endereco e = new Endereco("Rua x", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1000, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.TRUE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertTrue(m.validaEmpregado(emp));
        assertTrue(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_2(){
        Endereco e = new Endereco("", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1000, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_3(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_4(){
        Endereco e = new Endereco("Rua y", "" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_5(){
        Endereco e = new Endereco("Rua y", "São José" ,"" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_6(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_7(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,-2 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_8(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,-20);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_9(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_10(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "", "João", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_11(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "", 21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_12(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", -21, 1900, e);
        EasyMock.expect(dao.create(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.create(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_13(){
        EasyMock.expect(dao.read("")).andReturn(null);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertNull(m.read(""));
        EasyMock.verify(dao);
    }
    @Test
    public void test_14(){
        Endereco e = new Endereco("Rua x", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1000, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.TRUE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertTrue(m.validaEmpregado(emp));
        assertTrue(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_15(){
        Endereco e = new Endereco("", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1000, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_16(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_17(){
        Endereco e = new Endereco("Rua y", "" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_18(){
        Endereco e = new Endereco("Rua y", "São José" ,"" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_19(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_20(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,-2 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_21(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,-20);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_22(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("", "12345678912", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_23(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "", "João", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_24(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "", 21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_25(){
        Endereco e = new Endereco("Rua y", "São José" ,"Sousa" ,"PB" ,10 ,58804250);
        Empregado emp = new Empregado("1111-1", "12345678912", "João", -21, 1900, e);
        EasyMock.expect(dao.update(emp)).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.validaEmpregado(emp));
        assertFalse(m.update(emp));
        EasyMock.verify(dao);
    }
    @Test
    public void test_26(){
        EasyMock.expect(dao.delete("")).andReturn(Boolean.FALSE);
        EasyMock.replay(dao);
        EmpregadoManager m = new EmpregadoManager(dao);
        assertFalse(m.delete(""));
        EasyMock.verify(dao);
    }
    
    
    
}
