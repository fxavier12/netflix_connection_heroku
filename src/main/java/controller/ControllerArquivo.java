package controller;

import model.Arquivo;
import database.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ControllerArquivo{
	public static boolean SaveFile(Arquivo file)throws SQLException{

		ConexaoJDBC conexaojdbc = new ConexaoJDBC();
		Connection conexao = null;

		try{
			conexao = conexaojdbc.ConectaBD();
			String sql = "INSERT INTO files"
			+"(conteudo,extensao)"
			+"VALUES(?,?) returning id;";
			PreparedStatement preparedstatement = conexao.prepareStatement(sql);
            preparedstatement.setString(1,file.getConteudo());
            preparedstatement.setString(2,file.getExtensao());
            ResultSet result = preparedstatement.executeQuery();
            System.out.println(result);
            result.next();
            Integer id =  (Integer) result.getObject("id");
            file.setId(String.valueOf(id));

		}catch(Exception err){
			//tratar
			err.printStackTrace();	
			return false;
		}finally{
			if(conexao!=null)
				conexao.close();
		}
		
		return true;
	}

	public static Arquivo LoadById(String id)throws SQLException{
		Arquivo file = null;
		ConexaoJDBC conexaojdbc = new ConexaoJDBC();
		Connection conexao = null;
		try{
			conexao = conexaojdbc.ConectaBD();
			String sql = "SELECT * FROM files WHERE id = ?";
			PreparedStatement preparedstatement = conexao.prepareStatement(sql);
	        preparedstatement.setInt(1,Integer.parseInt(id));

		    ResultSet result = preparedstatement.executeQuery();
	    	
	    	if(result.next()){
	    		//encontrou
	    		String extensao = result.getString("extensao");
	    		String conteudo = result.getString("conteudo");

	    		file = new Arquivo(id,conteudo,extensao);
	     		
	        }
	     }catch(Exception err){
	     	err.printStackTrace();	
	     }

	     finally{
	     	if(conexao!=  null)
	     		conexao.close();
	     }
        
         
         return file;
	}



}
