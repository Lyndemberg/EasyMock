package Source;

public class Empregado {
    private String matricula;
    private String cpf;
    private String nome;
    private int idade;
    private float salario;
    private Endereco endereco;

    public Empregado(String matricula, String cpf, String nome, int idade, float salario, Endereco endereco) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.endereco = endereco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
