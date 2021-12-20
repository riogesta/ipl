public class groupRefactoring {
    public List getUsersSortedByMostRecentlyRegistered(){
        List users = new ArrayList();
        if (!userDirectoryExists())
            return users;
        addFoundUsersTo(users);
        SortedByMostRecentlyRegistered(users);

        return users;
    }
}