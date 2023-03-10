<template>
  <div style="width: 300px">
    <el-form :label-position="labelPosition" label-width="80px" :model="formInfo">
      <el-form-item style="visibility: hidden" label="id">
        <el-input v-model="formInfo.bookId"></el-input>
      </el-form-item>
      <el-form-item label="书名">
        <el-input v-model="formInfo.bookName"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="formInfo.bookPrice"></el-input>
      </el-form-item>
    </el-form>

    <el-button type="primary" @click="add()">添加</el-button>
    <el-button type="primary" @click="update()">修改</el-button>
  </div>
  <hr>
  <div class="table-container">

    <el-table :data="tableData" style="width: 100%">
      <el-table-column fixed prop="bookId" label="id" width="150" />
      <el-table-column prop="bookName" label="书名" width="120" />
      <el-table-column prop="bookPrice" label="价格" width="120" />
      <el-table-column fixed="right" label="Operations" width="130">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="tableToForm(scope.row)">修改</el-button>
          <el-button link type="primary" size="small" @click="deleteUser(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>


</template>

<script>
import axios from "axios";

export default {
  name: "UserView",
  methods: {
    tableToForm(row) {
      this.formInfo = row;
      console.log(row)
    },
    add() {
      const _this = this;
      axios.post('http://localhost:8080/book/addBook', {
          bookName: _this.formInfo.bookName,
          bookPrice: _this.formInfo.bookPrice
      });
    },
    update() {
      const _this = this;
      axios.put('http://localhost:8080/book/updateBook', {
          bookId: _this.formInfo.bookId,
          bookName: _this.formInfo.bookName,
          bookPrice: _this.formInfo.bookPrice
      });
    },
    deleteUser(row) {
      axios.delete('http://localhost:8080/book/deleteBook/' + row.bookId);
    }
  },
  created() {
    const _this = this;
    axios.get('http://localhost:8080/book/bookList').then(function (resp) {
      _this.tableData = resp.data;
    })
  },
  data() {
    return {
      tableData: [
        // {
        //   id: '2016-05-03',
        //   name: 'Tom',
        //   age: 'California',
        //   email: 'Los Angeles'
        // }
      ],
      labelPosition: 'right',
      formInfo: {
        bookId: '',
        bookName: '',
        bookPrice: '',
      }


    }
  }
}
</script>

<style scoped>
  .table-container {
    width: 520px;
  }
</style>
