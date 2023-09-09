RepositoryImpl
    @Override
    public List<EmploymentType> getAllEmType() {
        Session session = sessionFactory.getCurrentSession();
        try{
            Query q = session.createNamedQuery("EmploymentType.findAll");
        return q.getResultList();
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addOrUpdateEmType(EmploymentType employmentType) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (employmentType.getId() == null) {
                session.save(employmentType);
            } else {
                session.update(employmentType);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteEmTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (session.load(EmploymentType.class, id) != null) {
                session.delete(session.load(EmploymentType.class, id));
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }