import edu.aitu.oop3.db.DataBaseCreation;
import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.db.DbMemberRepository;
import repositories.MemberRepository;
import service.MemberService;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
public class Main {
    MemberRepository memberRepository = new DbMemberRepository();
    MemberService memberService = new MemberService(memberRepository);
    public void run(){

    }
    void main(){
        DataBaseCreation.init();
        new Main().run();
    }
}