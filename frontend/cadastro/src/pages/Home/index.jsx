import './style.css'
import Lixo from '../../assets/lixo.png'
import api from '../../service/api'
import { useEffect, useState } from 'react'



function Home() {

  const [users, setUsers] = useState([])

  async function getUsers(){
    const usersFromApi = await api.get('/ninjas/listar')
    setUsers(usersFromApi.data)
    console.log(users)
  }

  useEffect(() => {
    getUsers()
  }, [])
  

  return (


    <div className="container">
      <form action="">
        <h1>Cadastro</h1>
        <input placeholder="Nome" name="nome" type="text" />
        <input placeholder="Email" name="email" type="email" />
        <input placeholder="imgUrl" name="imagem" type="text" />
        <input placeholder="Idade" name="idade" type="number" />
        <input placeholder="Ranking" name="ranking" type="text" />
        <button>Cadastrar</button>
      </form>

      {users.map(user => (
        <div key={user.id} className='card'>
          <div>
            <p>Nome: <span>{user.nome}</span></p>
            <p>Idade: <span>{user.idade}</span></p>
            <p>Email: <span>{user.email}</span></p>
          </div>
          <div>
            <button><img src={Lixo} /></button>
          </div>
        </div>
      ))}

    </div>


  )
}

export default Home
