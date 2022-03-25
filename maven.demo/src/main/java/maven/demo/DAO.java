package maven.demo;

import java.sql.*;

public class DAO {
private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "postgres";
		String password = "1578";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean insertProduct(Product produto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO product (id_produto, nome_produto, cor_produto, tamanho_produto) "
					       + "VALUES ("+produto.getProdId()+ ", '" + produto.getProdName() + "', '"  
					       + produto.getProdColor() + "', '" + produto.getProdLength() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean updateProduct (Product produto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE product SET nome_produto = '" +produto.getProdName() + "', cor_produto = '"  
				       + produto.getProdColor() + "', tamanho_produto = '" + produto.getProdLength() + "'"
					   + " WHERE id_produto = " + produto.getProdId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean deleteProduct(int idProd) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM product WHERE id_produto = " + idProd);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Product[] getProducts() {
		Product[] produtos = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM product");		
	         if(rs.next()){
	             rs.last();
	             produtos = new Product[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                produtos[i] = new Product(rs.getInt("id_produto"), rs.getString("nome_produto"), 
	                		                  rs.getString("cor_produto"), rs.getString("tamanho_produto").charAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return produtos;
	}


}
