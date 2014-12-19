
package sistema.audizio.ultilitarios;

public class RemoveMascara {
   public String removeMascara(String cpf){
        String str = cpf;
        while (str.indexOf("-") != -1) {
          if (str.indexOf("-") != 0) {  
            str = str.substring(0, str.indexOf("-"))+str.substring(str.indexOf("-") + 1);  
          }else{  
            str = str.substring(str.indexOf("-") + 1);  
          }  
        }
        while (str.indexOf("/") != -1) {  
          if (str.indexOf("/") != 0) {  
            str = str.substring(0, str.indexOf("/"))+str.substring(str.indexOf("/") + 1);  
          }else {  
            str = str.substring(str.indexOf("/") + 1);  
          }  
        } 
        while (str.indexOf(".") != -1) {  
          if (str.indexOf(".") != 0) {  
            str = str.substring(0, str.indexOf("."))+str.substring(str.indexOf(".") + 1);  
          }else {  
            str = str.substring(str.indexOf(".") + 1);  
          }  
        }
        while (str.indexOf(" ") != -1) {  
          if (str.indexOf(" ") != 0) {  
            str = str.substring(0, str.indexOf(" "))+str.substring(str.indexOf(" ") + 1);  
          }else {  
            str = str.substring(str.indexOf(" ") + 1);  
          }  
        }
        while (str.indexOf(":") != -1) {  
          if (str.indexOf(":") != 0) {  
            str = str.substring(0, str.indexOf(":"))+str.substring(str.indexOf(":") + 1);  
          }else {  
            str = str.substring(str.indexOf(":") + 1);  
          }  
        }
        while (str.indexOf("(") != -1) {  
          if (str.indexOf("(") != 0) {  
            str = str.substring(0, str.indexOf("("))+str.substring(str.indexOf("(") + 1);  
          }else {  
            str = str.substring(str.indexOf("(") + 1);  
          }  
        }
        while (str.indexOf(")") != -1) {  
          if (str.indexOf(")") != 0) {  
            str = str.substring(0, str.indexOf(")"))+str.substring(str.indexOf(")") + 1);  
          }else {  
            str = str.substring(str.indexOf(")") + 1);  
          }  
        }
         while (str.indexOf(",") != -1) {  
          if (str.indexOf(",)") != 0) {  
            str = str.substring(0, str.indexOf(","))+str.substring(str.indexOf(",") + 1);  
          }else {  
            str = str.substring(str.indexOf(",") + 1);  
          }  
        }
        return str;
      } 
}
