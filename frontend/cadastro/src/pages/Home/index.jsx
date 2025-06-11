import './style.css'
import Lixo from '../../assets/lixo.png'
import api from '../../service/api'
import { useEffect, useState,useRef } from 'react'

// useRef



function Home() {

  const [users, setUsers] = useState([])

  const inputNome = useRef()
  const inputEmail = useRef()
  const inputImgUrl = useRef()
  const inputIdade = useRef()
  const inputRank = useRef()

  async function getUsers(){
    const usersFromApi = await api.get('/ninjas/listar')
    setUsers(usersFromApi.data)
    console.log(users)
  }

    async function createUsers(){
    const usersFromApi = await api.post('/ninjas/criar',{
      nome: inputNome.current.value,
      email: inputEmail.current.value,
      imgUrl: inputImgUrl.current.value,
      idade: inputIdade.current.value,
      ranking: inputRank.current.value

    })
    getUsers()
  }

    async function deleteUsers(id){
    await api.delete(`/ninjas/apagar/${id}`)
    getUsers()
  }

  useEffect(() => {
    getUsers()
  }, [])
  

  return (


    <div className="container">
      <form action="">
        <h1>Cadastro</h1>
        <input placeholder="Nome" name="nome" type="text" ref={inputNome} />
        <input placeholder="Email" name="email" type="email" ref={inputEmail}/>
        <input placeholder="imgUrl" name="imagem" type="text" ref={inputImgUrl}/>
        <input placeholder="Idade" name="idade" type="number" ref={inputIdade}/>
        <input placeholder="Ranking" name="ranking" type="text" ref={inputRank}/>
        <button type="button" onClick={createUsers}>Cadastrar</button>
      </form>

      {users.map(user => (
        <div key={user.id} className='card'>
          <div>
            <p>Nome: <span>{user.nome}</span></p>
            <p>Idade: <span>{user.idade}</span></p>
            <p>Email: <span>{user.email}</span></p>
          </div>
          <div>
            <button onClick={() => deleteUsers(user.id)}><img src={Lixo} /></button>
          </div>
        </div>
      ))}

    </div>


  )
}

export default Home
