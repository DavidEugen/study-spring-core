package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memebrRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memebrRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memebrRepository.findById(memberId);
    }
}
