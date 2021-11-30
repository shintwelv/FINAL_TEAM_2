import styled from 'styled-components'

export const ButtonGroupWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 24px 0;
`

export const Button = styled.button`
  width: 64px;
  height: 32px;
  border-radius: 6px;
  color: #fff;
  background-color: #0593f0;
  margin-right: 8px;
  &:last-child {
    margin: 0;
  }
`
