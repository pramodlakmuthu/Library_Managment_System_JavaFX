package Controllers.AddMember;

import Model.Members;
import java.util.ArrayList;
import java.util.List;

public class MemberController {
    // In-memory list to store registered members (can be replaced with database calls later)
    private static List<Members> memberList = new ArrayList<>();

    public boolean addMember(Members member) {
        if (member != null && member.getMemberId() != null && !member.getMemberId().isEmpty()) {
            memberList.add(member);
            return true;
        }
        return false;
    }

    public int getTotalMembersCount() {
        return memberList.size();
    }

    public List<Members> getAllMembers() {
        return memberList;
    }
}